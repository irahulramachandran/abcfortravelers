using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MySql.Data;
using System.Configuration;
using MySql.Data.MySqlClient;
using System.Data;
using System.Data.Common;
using System.Data.SqlClient;

namespace ABCForTravelers.DAL
{
    public class CommonDAL
    {
        public static MySqlConnection CreateConnection()
        {
            string sqlConnection = ConfigurationManager.ConnectionStrings["ABCForTravelerConnection"].ConnectionString;
            MySqlConnection con = new MySqlConnection(sqlConnection);
            return con;
        }

        public static MySqlCommand OpenConnection(MySqlConnection con, string procedureName, out MySqlCommand dbcommand)
        {
            if (con.State == ConnectionState.Closed)
                con.Open();
            dbcommand = new MySqlCommand(procedureName, con);
            dbcommand.CommandType = CommandType.StoredProcedure;
            return dbcommand;
        }

        public static void CloseConnection(MySqlConnection con)
        {
            con.Close();
            con.Dispose();
        }

        public static bool ExecuteNonQuery(MySqlConnection con, MySqlCommand dbcommand)
        {
            int output = dbcommand.ExecuteNonQuery();
            CloseConnection(con);
            return (output > 0) ? true : false;
        }

        public static DataTable ExecuteReader(MySqlConnection con, MySqlCommand dbcommand)
        {
            MySqlDataReader dr = dbcommand.ExecuteReader();
            DataTable datatable = new DataTable();
            datatable.Load(dr);
            CloseConnection(con);
            return datatable;
        }
    }
}
