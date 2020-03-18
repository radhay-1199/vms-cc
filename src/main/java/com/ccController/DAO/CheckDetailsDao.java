package com.ccController.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.ccController.model.VmsUsersModel;

@Component
public class CheckDetailsDao {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public VmsUsersModel getDetails(String msisdn) {
		try {
			logger.info("Checking for msisdn in vms_users table");
			String query="select * from vms_users inner join vms_packs on vms_users.pack_id=vms_packs.pack_id where msisdn='"+msisdn+"'";
			logger.info("query: "+query);
			return jdbcTemplate.query(query,new ResultSetExtractor<VmsUsersModel>(){

				@Override
				public VmsUsersModel extractData(ResultSet rs) throws SQLException, DataAccessException {
					VmsUsersModel vmsuser = new VmsUsersModel();
					while(rs.next()) {						
						vmsuser.setMsisdn(rs.getString("msisdn"));
						vmsuser.setStatus(rs.getInt("status"));
						vmsuser.setPackName(rs.getString("pack_name"));
						vmsuser.setNextRenewalDate(rs.getString("next_renewal_date"));
						vmsuser.setHlrFlag(rs.getInt("hlr_flag"));
						vmsuser.setCreateTime(rs.getString("create_time"));
						vmsuser.setLangCode(rs.getInt("lang_code"));
						vmsuser.setSubMode(rs.getString("sub_mode"));
						vmsuser.setChannel(rs.getString("channel"));
						vmsuser.setRenewalFlag(rs.getInt("renewal_flag"));
						vmsuser.setdFlag(rs.getString("d_flag"));
					}
					return vmsuser;
				}	
			});
		}catch(Exception e) {
			logger.info("exception checking for msisdn in vms_users: "+e);
			e.printStackTrace();
			return null;
		}
	}
}
