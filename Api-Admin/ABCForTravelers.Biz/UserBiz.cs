using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using ABCForTravelers.DAL;
using ABCForTravelers.EN;

namespace ABCForTravelers.Biz
{
    public class UserBiz
    {
        public UserEN Login(UserEN user)
        {
            UserDAL userDAL = new UserDAL();
            UserEN activeUser = userDAL.Find(user);
            if(activeUser.ID != 0)
            {
                string password = Util.EnryptDecrypt.Decrypt(activeUser.Password, true);
                if(password == user.Password)
                {
                    activeUser.Password = string.Empty;
                    return activeUser;
                }
            }
            return null;
        }

        public UserEN Register(UserEN registerUser)
        {
            UserDAL userDAL = new UserDAL();
            UserEN existingUser = userDAL.Find(registerUser);
            if (existingUser.ID == 0)
            {
                registerUser.Password = Util.EnryptDecrypt.Encrypt(registerUser.Password, true);
                registerUser.Status = 1;
                UserEN activeUser = userDAL.Save(registerUser);
                if (activeUser.ID != 0)
                {
                    activeUser.Password = "";
                    return activeUser;
                }
                return null;
            }
            return null;
        }
    }
}
