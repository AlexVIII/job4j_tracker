
package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] user, String login) throws UserNotFoundException {
        for (User value : user) {
            if (value.getUsername().equals(login)) {
                return value;
            }
        }
        throw new UserInvalidException("User don't found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User don't valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException l) {
            l.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}