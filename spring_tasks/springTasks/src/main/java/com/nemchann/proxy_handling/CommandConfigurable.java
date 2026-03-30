package com.nemchann.proxy_handling;

import java.util.List;

public interface CommandConfigurable {
    List<MethodCommand> getCommands();
    void addCommand(MethodCommand command);
}
