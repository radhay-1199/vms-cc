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
public class VmsUsersDao {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public VmsUsersModel getUserDetails(String msisdn) {
		String query ="select * from vms_users where msisdn='"+msisdn+"'";
		logger.info("query: "+query);
		return jdbcTemplate.query(query,new ResultSetExtractor<VmsUsersModel>() {

			@Override
			public VmsUsersModel extractData(ResultSet rs) throws SQLException, DataAccessException {
				VmsUsersModel vmsUser = new VmsUsersModel();
				while(rs.next()) {
					vmsUser.setMsisdn(rs.getString("msisdn"));
					vmsUser.setStatus(rs.getInt("status"));
					vmsUser.setPackId(rs.getString("pack_id"));
					vmsUser.setNextRenewalDate(rs.getString("next_renewal_date"));
					vmsUser.setHlrFlag(rs.getInt("hlr_flag"));
					vmsUser.setCreateTime(rs.getString("create_time"));
					vmsUser.setLangCode(rs.getInt("lang_code"));
					vmsUser.setSubMode(rs.getString("sub_mode"));
					vmsUser.setChannel(rs.getString("channel"));
					vmsUser.setRenewalFlag(rs.getInt("renewal_flag"));
					vmsUser.setdFlag(rs.getString("d_flag"));
				}
				return vmsUser;
			}
			
		});
	}

}
