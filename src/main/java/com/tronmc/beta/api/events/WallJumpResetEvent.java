package com.tronmc.beta.api.events;

import com.tronmc.beta.player.WPlayer;
import org.jetbrains.annotations.NotNull;

public class WallJumpResetEvent extends WallJumpEvent {

    public WallJumpResetEvent(@NotNull WPlayer who) {
        super(who);
    }

}
