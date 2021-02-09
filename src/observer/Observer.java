package observer;

public interface Observer {

    /**
     * Update method: receives the notification from the subject
     * @param message
     */
    void update(String message);
}
