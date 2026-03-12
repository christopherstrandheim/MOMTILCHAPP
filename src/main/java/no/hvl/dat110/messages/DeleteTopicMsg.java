package no.hvl.dat110.messages;

public class DeleteTopicMsg extends Message {

	// message sent from client to create topic on the broker
private String topic;

    public DeleteTopicMsg(String user, String topic) {
        super(MessageType.DELETETOPIC,user);
        this.topic= topic;
    }

	// TODO:
	// Implement object variables - a topic is required

    public String getTopic() {
        return topic;
    }

    @Override
    public String toString() {
        return "DeleteTopicMsg{" +
                "topic='" + topic + '\'' +
                '}';
    }
    // Complete the constructor, get/set-methods, and toString method
	// as described in the project text

}
