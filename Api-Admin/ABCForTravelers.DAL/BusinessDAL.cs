using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using ABCForTravelers.EN;
using MySql.Data.MySqlClient;

namespace ABCForTravelers.DAL
{
    public class BusinessDAL
    {
        public BusinessEN Save(BusinessEN business)
        {
            MySqlConnection con = CommonDAL.CreateConnection();
            try
            {
                MySql.Data.MySqlClient.MySqlCommand dbcommand = null;
                CommonDAL.OpenConnection(con, "business_add", out dbcommand);
                dbcommand.Parameters.AddWithValue("param_categoryId", business.Category.ID);
                dbcommand.Parameters.AddWithValue("param_name", business.Name);
                dbcommand.Parameters.AddWithValue("param_description", business.Description);
                dbcommand.Parameters.AddWithValue("param_lat", business.Latitude);
                dbcommand.Parameters.AddWithValue("param_log", business.Longitude);
                dbcommand.Parameters.AddWithValue("param_currency", business.Currency);
                dbcommand.Parameters.AddWithValue("param_price", business.Price);
                dbcommand.Parameters.AddWithValue("param_userId", business.User.ID);

                object id = dbcommand.ExecuteScalar();
                business.ID = Convert.ToInt32(id);
                return business;
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

        public bool SaveContact(BusinessEN business, ContactsEN contact)
        {
            MySqlConnection con = CommonDAL.CreateConnection();
            try
            {
                MySql.Data.MySqlClient.MySqlCommand dbcommand = null;
                CommonDAL.OpenConnection(con, "bizcontact_add", out dbcommand);
                dbcommand.Parameters.AddWithValue("param_businessid", business.ID);
                dbcommand.Parameters.AddWithValue("param_phonenumber", contact.Phonenumber);
                dbcommand.Parameters.AddWithValue("param_emailid", contact.EmailID);
                dbcommand.Parameters.AddWithValue("param_address", contact.Address);

                object id = dbcommand.ExecuteScalar();
                contact.ID = Convert.ToInt32(id);
                if (contact.ID != 0)
                {
                    return true;
                }
                return false;
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

        public bool UpdatePhoto(int id, string fileName)
        {
            MySqlConnection con = CommonDAL.CreateConnection();
            try
            {
                MySql.Data.MySqlClient.MySqlCommand dbcommand = null;
                CommonDAL.OpenConnection(con, "business_updatephoto", out dbcommand);
                dbcommand.Parameters.AddWithValue("param_businessid", id);
                dbcommand.Parameters.AddWithValue("param_filename", fileName);

                int rows = dbcommand.ExecuteNonQuery();
                if( rows > 0)
                {
                    return true;
                }
                return false;
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

        public string GetPhoto(int id)
        {
            MySqlConnection con = CommonDAL.CreateConnection();
            try
            {
                MySql.Data.MySqlClient.MySqlCommand dbcommand = null;
                CommonDAL.OpenConnection(con, "business_getphoto", out dbcommand);
                dbcommand.Parameters.AddWithValue("param_businessid", id);

                object fileName = dbcommand.ExecuteScalar();
                return (string) fileName;
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

        public List<BusinessEN> GetByGeo(float latitude, float longitude)
        {
            MySqlConnection con = CommonDAL.CreateConnection();
            try
            {
                MySql.Data.MySqlClient.MySqlCommand dbcommand = null;
                CommonDAL.OpenConnection(con, "business_getbygeo", out dbcommand);
                dbcommand.Parameters.AddWithValue("param_latitude", latitude);
                dbcommand.Parameters.AddWithValue("param_longitude", longitude);
                List<BusinessEN> businesses = new List<BusinessEN>(); 
                MySqlDataReader reader = dbcommand.ExecuteReader();
                if(reader.HasRows)
                {
                    DataTable schemaTable = new DataTable();
                    schemaTable.Load(reader);

                    foreach (DataRow row in schemaTable.Rows)
                    {
                        BusinessEN business = new BusinessEN();
                        business.ID = Convert.ToInt32(row[0].ToString());
                        CategoryEN category = new CategoryEN();
                        category.ID = Convert.ToInt32(row["categoryid"].ToString());
                        category.Name = row["categoryname"].ToString();
                        business.Category = category;
                        business.Name = row["name"].ToString();
                        business.Description = row["description"].ToString();
                        business.Longitude = Convert.ToSingle(row["longitude"].ToString());
                        business.Latitude = Convert.ToSingle(row["latitude"].ToString());
                        business.Currency = row["currency"].ToString();
                        if(row["price"] != DBNull.Value)
                        {
                            business.Price = Convert.ToDecimal(row["price"].ToString());    
                        }
                        string distance = row["distance"].ToString();
                        decimal d = Decimal.Parse(distance, System.Globalization.NumberStyles.Float);
                        business.Distance = Convert.ToString(Convert.ToInt32(d)) + " KM";
                        businesses.Add(business);
                    }
                }
                return businesses;
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
