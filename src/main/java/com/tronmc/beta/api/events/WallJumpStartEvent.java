package com.tronmc.beta.api.events;

import com.tronmc.beta.player.WPlayer;
import org.jetbrains.annotations.NotNull;
import org.bukkit.event.Cancellable;

public class WallJumpStartEvent extends WallJumpEvent implements Cancellable {

    public WallJumpStartEvent(@NotNull WPlayer who) {
        super(who);
    }
}
