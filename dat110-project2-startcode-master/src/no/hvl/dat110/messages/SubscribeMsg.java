package no.hvl.dat110.messages;

public class SubscribeMsg extends Message {

	private String topic;
	
	// message sent from client to subscribe on a topic 

	// TODO:
	// Implement object variables - a topic is required

	public SubscribeMsg(String name, String topic) {
		super(MessageType.SUBSCRIBE, name);
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
