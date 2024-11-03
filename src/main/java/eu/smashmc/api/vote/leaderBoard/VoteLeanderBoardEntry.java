package eu.smashmc.api.vote.leaderBoard;

import eu.smashmc.api.identity.minecraft.MinecraftIdentity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

public interface VoteLeanderBoardEntry {

    UUID getUuid();

    int getScore();

    MinecraftIdentity getIdentity();

    String getName();


}
