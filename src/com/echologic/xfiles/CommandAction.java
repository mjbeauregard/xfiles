/*
 * Copyright (C) 2005 Derek Scherger <derek@echologic.com> All Rights Reserved.
 *
 * license to be determined.
 */
package com.echologic.xfiles;

import javax.swing.Icon;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;

/**
 * @author <a href="mailto:derek@echologic.com">Derek Scherger</a>
 */
public class CommandAction extends AnAction {

    private boolean enabled;

    private Command command;

    public CommandAction(String text, String description, Icon icon) {
        super(text, description, icon);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void update(AnActionEvent e) {
        Presentation presentation = e.getPresentation();
        presentation.setEnabled(enabled);
    }

    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void actionPerformed(AnActionEvent e) {
        command.execute();
    }
}
