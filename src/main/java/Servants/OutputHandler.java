package Servants;

import DBClasses.User;

public interface OutputHandler {
    public void writeTheUserToTheFile(final User user);
}
