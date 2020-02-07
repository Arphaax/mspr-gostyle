package fr.epsi.b3.gostyle.service;

import fr.epsi.b3.gostyle.dao.UserDao;
import fr.epsi.b3.gostyle.exception.UserNotFoundException;
import fr.epsi.b3.gostyle.model.Qrcode;
import fr.epsi.b3.gostyle.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private HashingServices hashingServices;

    public User getById(int id) throws UserNotFoundException {
        User user = userDao.getById(id);
        if(user == null) {
        	throw new UserNotFoundException("Utilisateur not found");
        }
        return user;
    }

    public User getByLogin(String numero) { return userDao.getByLogin(numero); }

    public boolean verifyLogins(String numero, String passwd) {
        User user = getByLogin(numero);

        if (user == null) {
            return false;
        }
        else {
            if (hashingServices.verifier(passwd, user.getPasswd())) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public List<Qrcode> getAllQrCodesOfUser(int id) {
        return userDao.getAllQrCodesOfUser(id);
    }
}
