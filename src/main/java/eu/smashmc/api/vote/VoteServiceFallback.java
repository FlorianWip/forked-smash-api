package eu.smashmc.api.vote;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

class VoteServiceFallback implements VoteService {
    @Override
    public CompletableFuture<Integer> getVoteStreak(UUID uuid) {
        return CompletableFuture.completedFuture(0);
    }

    @Override
    public CompletableFuture<List<Vote>> getVotes(UUID uuid) {
        return CompletableFuture.completedFuture(List.of());
    }

    @Override
    public CompletableFuture<Vote> getLastVote(UUID uuid) {
        return CompletableFuture.completedFuture(getDummyVote());
    }

    @Override
    public CompletableFuture<Void> submitVoteAsClaimed(long voteId) {

        return CompletableFuture.completedFuture(null);
    }

    private Vote getDummyVote() {
        return new Vote() {
            @Override
            public UUID getUuid() {
                return UUID.randomUUID();
            }

            @Override
            public long getVoteId() {
                return new Random().nextLong();
            }

            @Override
            public String getSite() {
                return "dummySite";
            }

            @Override
            public long getTimeStamp() {
                return System.currentTimeMillis() - 1000L;
            }

            @Override
            public String getIp() {
                return "0.0.0.0";
            }
        };
    }
}
