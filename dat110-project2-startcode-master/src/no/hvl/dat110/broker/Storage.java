package no.hvl.dat110.broker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import no.hvl.dat110.common.TODO;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.Logger;
import no.hvl.dat110.messagetransport.Connection;

public class Storage {

	// data structure for managing subscriptions
	// maps from a topic to set of subscribed users
	protected ConcurrentHashMap<String, Set<String>> subscriptions;
	
	// data structure for managing currently connected clients
	// maps from user to corresponding client session object
	
	protected ConcurrentHashMap<String, ClientSession> clients;
	
	protected ConcurrentHashMap<String,Boolean> link;
	
	protected ConcurrentHashMap<String,ArrayList<Message>> buffer;

	public Storage() {
		subscriptions = new ConcurrentHashMap<String, Set<String>>();
		clients = new ConcurrentHashMap<String, ClientSession>();
		
		link = new ConcurrentHashMap<String, Boolean>();
		buffer = new ConcurrentHashMap<String, ArrayList<Message>>();
	}

	public Collection<ClientSession> getSessions() {
		return clients.values();
	}

	public Set<String> getTopics() {

		return subscriptions.keySet();

	}

	// get the session object for a given user
	// session object can be used to send a message to the user
	
	public ClientSession getSession(String user) {

		ClientSession session = clients.get(user);

		return session;
	}

	public Set<String> getSubscribers(String topic) {

		return (subscriptions.get(topic));

	}

	public void addClientSession(String user, Connection connection) {

		// TODO: add corresponding client session to the storage
		// See ClientSession class
		
		ClientSession session = new ClientSession(user, connection);
		clients.put(user, session);
		link.put(user, true);
		buffer.put(user, new ArrayList<Message>());
		
	}

	public void removeClientSession(String user) {

		// TODO: disconnet the client (user) 
		// and remove client session for user from the storage
		
		clients.remove(user);
		
	}

	public void createTopic(String topic) {

		// TODO: create topic in the storage

		subscriptions.put(topic, new HashSet<>());
	
	}

	public void deleteTopic(String topic) {

		// TODO: delete topic from the storage

		subscriptions.remove(topic);
		
	}

	public void addSubscriber(String user, String topic) {

		// TODO: add the user as subscriber to the topic
		
		if (subscriptions.containsKey(topic)) {
			subscriptions.get(topic).add(user);
		}
		
	}

	public void removeSubscriber(String user, String topic) {

		// TODO: remove the user as subscriber to the topic

		if (subscriptions.containsKey(topic)) {
			subscriptions.get(topic).remove(user);
		}
	}

	public boolean isLinked(String user) {
		return link.get(user);
	}

	public void addToBuffer(String user, PublishMsg msg) {
		buffer.get(user).add(msg);
		
	}
}
