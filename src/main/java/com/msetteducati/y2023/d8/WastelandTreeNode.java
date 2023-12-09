package com.msetteducati.y2023.d8;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WastelandTreeNode {

    private static final String ROOT_LABEL = "AAA";
    private static final char ROOT_GHOST_LABEL_END = 'A';
    private static final String TERMINAL_LABEL = "ZZZ";
    private static final char TERMINAL_GHOST_LABEL_END = 'Z';

    private final String label;
    private WastelandTreeNode left;
    private WastelandTreeNode right;

    public WastelandTreeNode(String label) {
        this.label = label;
    }

    public boolean isRoot() {
        return ROOT_LABEL.equals(this.getLabel());
    }

    public boolean isRootForGhost() {
        return this.label.charAt(2) == ROOT_GHOST_LABEL_END;
    }

    public boolean isTerminal() {
        return TERMINAL_LABEL.equals(this.getLabel());
    }

    public boolean isTerminalForGhost() {
        return this.label.charAt(2) == TERMINAL_GHOST_LABEL_END;
    }
}
