package com.main.viikko10uusi;


import android.content.Context;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserStorage {
    private ArrayList<User> users = new ArrayList<>();

    private static UserStorage userStorage = null;

    private UserStorage() {
    }

    public static UserStorage getInstance() {
        if (userStorage == null) {
            userStorage = new UserStorage();
        }
        return userStorage;

    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }



    public void saveUsers(Context context) {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(users);
            userWriter.close();


            System.out.println("Tallentaminen onnistui");
        } catch (IOException e) {
            System.out.println("Käyttäjien tallentaminen ei onnistunut");
            e.printStackTrace();

        }

    }

    public void loadUsers(Context context) {
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>) userReader.readObject();
            userReader.close();
            System.out.println("Lataaminen onnistui");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Käyttäjien lukeminen ei onnistunut");
            e.printStackTrace();
        }

    }
}
