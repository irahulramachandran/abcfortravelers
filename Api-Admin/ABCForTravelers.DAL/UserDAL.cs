using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using ABCForTravelers.EN;
using MySql.Data.MySqlClient;

namespace ABCForTravelers.DAL
{
    public class UserDAL
    {
        public UserEN Find(UserEN user)
        {
            MySqlConnection con = CommonDAL.CreateConnection();
            try
            {
                MySql.Data.MySqlClient.MySqlCommand dbcommand = null;
                CommonDAL.OpenConnection(con, "user_login", out dbcommand);
                dbcommand.Parameters.AddWithValue("param_emailId", user.EmailID);
                DataTable dt = CommonDAL.ExecuteReader(con, dbcommand);
                UserEN returnuser = new UserEN();
                if (dt.Rows.Count == 1)
                {
                    for (int i = 0; i < dt.Rows.Count; i++)
                    {
                        returnuser.ID = Convert.ToInt32(dt.Rows[i]["id"].ToString());
                        returnuser.Name = dt.Rows[i]["name"].ToString();
                        returnuser.EmailID = dt.Rows[i]["emailId"].ToString();
                        returnuser.Phonenumber = dt.Rows[i]["phonenumber"].ToString();
                        returnuser.Password = dt.Rows[i]["password"].ToString();
                        returnuser.Photourl = dt.Rows[i]["photourl"].ToString();
                        returnuser.Usertype = Convert.ToInt32(dt.Rows[i]["usertype"].ToString());
                        returnuser.Status = Convert.ToInt32(dt.Rows[i]["status"].ToString());
                        returnuser.CreatedOn = Convert.ToDateTime(dt.Rows[i]["createdOn"].ToString());
                    }
                }
                return returnuser;
            }
            catch (Exception e1)
            {
                throw new Exception(e1.Message);
            }
            finally
            {
                con.Close();
            }
        }

        public UserEN Save(UserEN registerUser)
        {
            MySqlConnection con = CommonDAL.CreateConnection();
            try
            {
                MySql.Data.MySqlClient.MySqlCommand dbcommand = null;
                CommonDAL.OpenConnection(con, "user_add", out dbcommand);
                dbcommand.Parameters.AddWithValue("param_name", registerUser.Name);
                dbcommand.Parameters.AddWithValue("param_emailId", registerUser.EmailID);
                dbcommand.Parameters.AddWithValue("param_phonenumber", registerUser.Phonenumber);
                dbcommand.Parameters.AddWithValue("param_password", registerUser.Password);
                dbcommand.Parameters.AddWithValue("param_photourl", registerUser.Photourl);
                dbcommand.Parameters.AddWithValue("param_usertype", registerUser.Usertype);
                dbcommand.Parameters.AddWithValue("param_status", registerUser.Status);

                object id = dbcommand.ExecuteScalar();
                registerUser.ID = Convert.ToInt32(id);
                return registerUser;
                return null;
            }
            catch (Exception e1)
            {
                throw new Exception(e1.Message);
            }
            finally
            {
                con.Close();
            }
        }
    }
}
