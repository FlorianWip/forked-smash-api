package eu.smashmc.api.vote;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface VoteService {


    CompletableFuture<Integer> getVoteStreak(UUID uuid);

    CompletableFuture<List<Vote>> getVotes(UUID uuid);

    CompletableFuture<Vote> getLastVote(UUID uuid);

    CompletableFuture<Void> submitVoteAsClaimed(long voteId);
}
