package no.hvl.dat110.messages;

public class PublishMsg extends Message {
	
	private String topic;
	private String message;
	
	// message sent from client to create publish a message on a topic 

	// TODO:
	// Implement object variables - a topic and a message is required

	public PublishMsg(String name, String topic, String message) {
		super(MessageType.PUBLISH, name);
		this.topic = topic;
		this.message = message;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTopic() {
		return topic;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Message [topic=" + topic + ", type=" + getType() + ", user=" + getUser() + ", message=" + message + "]";
	}
	
	// Constructor, get/set-methods, and toString method
	// as described in the project text
	
	
}
