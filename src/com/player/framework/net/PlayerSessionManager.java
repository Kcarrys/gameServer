package com.player.framework.net;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public enum PlayerSessionManager {

	INSTANCE;

	private ConcurrentMap<Long, IdSession> Storage = new ConcurrentHashMap<>();
	
	public long getPlayerId(IdSession session) {
		if (session != null) {
			return session.getPlayerId();
		}
		return 0;
	}

	public IdSession getPlayerSession(long playerId) {
		return this.Storage.get(playerId);
	}

	public void setPlayerSession(long playerId, IdSession session) {
		session.setAttribute(SessionProperty.PLAYER_ID, playerId);
		this.Storage.put(playerId, session);
	}

}
