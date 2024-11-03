package eu.smashmc.api.vote;

import eu.smashmc.api.identity.minecraft.MinecraftIdentity;
import eu.smashmc.api.vote.leaderBoard.VoteLeaderBoard;
import eu.smashmc.api.vote.leaderBoard.VoteLeanderBoardEntry;

import java.util.*;
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
    public CompletableFuture<List<Vote>> getUnclaimedVotes(UUID uuid) {
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

    @Override
    public CompletableFuture<VoteLeaderBoard> getStreakLeaderBoard(int limit) {
        return CompletableFuture.completedFuture(new VoteLeaderBoard() {

            private final List<VoteLeanderBoardEntry> entries = new ArrayList<>();

            @Override
            public List<VoteLeanderBoardEntry> getEntries() {
                init();
                return entries;
            }

            @Override
            public VoteLeanderBoardEntry getEntry(int index) {
                init();
                return entries.get(index);
            }

            private void init() {
                if (entries.size() < limit) {
                    for (int i = entries.size(); i < limit; i++) {
                        entries.add(getDummyLeaderBoardEntry());
                    }
                }
            }
        });
    }

    @Override
    public CompletableFuture<VoteLeaderBoard> getVoteCountLeaderBoard(int limit) {
        return null;
    }

    private VoteLeanderBoardEntry getDummyLeaderBoardEntry() {
        return new VoteLeanderBoardEntry() {
            @Override
            public UUID getUuid() {
                return UUID.randomUUID();
            }

            @Override
            public int getScore() {
                return 0;
            }

            @Override
            public MinecraftIdentity getIdentity() {
                return null;
            }

            @Override
            public String getName() {
                return "dummyName";
            }
        };
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
