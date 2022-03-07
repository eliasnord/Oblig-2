package no.hvl.dat110.messages;

public class DeleteTopicMsg extends Message {

	private String topic;
	
	// message sent from client to create topic on the broker

	// TODO:
	// Implement object variables - a topic is required

	public DeleteTopicMsg(String user, String topic) {
		super(MessageType.DELETETOPIC, user);
		this.topic = topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public String getTopic() {
		return topic;
	}
	@Override
	public String toString() {
		return "Message [topic=" + topic + ", type=" + getType() + ", user=" + getUser() + "]";
	}
	
	// Constructor, get/set-methods, and toString method
	// as described in the project text

}
