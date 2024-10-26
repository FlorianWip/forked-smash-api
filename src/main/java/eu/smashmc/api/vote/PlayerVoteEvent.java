package eu.smashmc.api.vote;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

/**
 * A {@link Bukkit} {@link Event} that is called when a {@link Player} votes for
 * a server.
 *
 * @author Flammenfuchs_YT
 *
 */
public class PlayerVoteEvent extends PlayerEvent {

	private static final HandlerList handlers = new HandlerList();

	private Vote vote;

	public PlayerVoteEvent(Player who, Vote vote) {
		super(who);
		this.vote = vote;
	}

	/**
	 * Returns the {@link Vote}
	 *
	 * @return the {@link Vote}
	 */
	public Vote getVote() {
		return vote;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

}
