package eu.smashmc.api.vote;

import eu.smashmc.api.Environment;
import eu.smashmc.api.SmashComponent;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@SmashComponent(value = {Environment.BUKKIT}, fallbackImpl = VoteServiceFallback.class)
public interface VoteService {


    CompletableFuture<Integer> getVoteStreak(UUID uuid);

    CompletableFuture<List<Vote>> getVotes(UUID uuid);

    CompletableFuture<Vote> getLastVote(UUID uuid);

    CompletableFuture<Void> submitVoteAsClaimed(long voteId);
}
