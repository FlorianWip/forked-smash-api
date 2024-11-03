package eu.smashmc.api.vote.leaderBoard;

import java.util.List;

public interface VoteLeaderBoard {

    List<VoteLeanderBoardEntry> getEntries();

    VoteLeanderBoardEntry getEntry(int index);
}
