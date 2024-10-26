package eu.smashmc.api.vote;

import java.util.Optional;
import java.util.UUID;

/**
 *
 * Represents a vote.
 *
 */
public interface Vote {

    /**
     * Get the uuid of the player, who submitted this vote.
     *
     * @return {@link UUID} of the player.
     */
    UUID getUuid();

    /**
     * Get the id of the vote.
     *
     * @return the id of the vote.
     */
    long getVoteId();

    /**
     * Get the site where the vote was submitted.
     *
     * @return the site where the vote was submitted.
     */
    String getSite();

    /**
     * Get the time, when the vote was submitted.
     *
     * @return the time as UNIX-Timestamp.
     */
    long getTimeStamp();

    /**
     * Get the ip of the player, who submitted this vote.
     * DANGER: The ip may be invalid or censored.
     *
     * @return the ip provided from the site.
     */
    String getIp();

}
