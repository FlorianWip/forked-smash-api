package eu.smashmc.api.vote;

import eu.smashmc.api.Environment;
import eu.smashmc.api.SmashComponent;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@SmashComponent(value = {Environment.BUKKIT}, fallbackImpl = VoteServiceFallback.class)
public interface VoteService {

    /**
     * Get the current vote streak of a player.
     *
     * @param uuid the {@link UUID} of the player
     * @return A {@link CompletableFuture} completing the vote streak of the player
     */
    CompletableFuture<Integer> getVoteStreak(UUID uuid);

    /**
     * Get all votes of a player.
     *
     * @param uuid the {@link UUID} of the player
     * @return A {@link CompletableFuture} completing a {@link List} of all {@link Vote} of the player
     */
    CompletableFuture<List<Vote>> getVotes(UUID uuid);

    /**
     * Get all unclaimed votes of a player.
     *
     * @param uuid the {@link UUID} of the player
     * @return A {@link CompletableFuture} completing a {@link List} of all unclaimed {@link Vote} of the player
     */
    CompletableFuture<List<Vote>> getUnclaimedVotes(UUID uuid);

    /**
     * Get the last vote of a player.
     *
     * @param uuid the {@link UUID} of the player
     * @return A {@link CompletableFuture} completing the last submitted {@link Vote} of the player
     */
    CompletableFuture<Vote> getLastVote(UUID uuid);

    /**
     * Submit a vote as claimed.
     *
     * @param voteId the id of the vote
     * @return A {@link CompletableFuture} completing when the vote has been submitted as claimed
     */
    CompletableFuture<Void> submitVoteAsClaimed(long voteId);
}
