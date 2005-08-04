/*
 * Copyright (C) 2005 Derek Scherger <derek@echologic.com> All Rights Reserved.
 *
 * license to be determined.
 */
package com.echologic.xfiles;

import java.util.ArrayList;
import java.util.List;

import com.intellij.openapi.roots.ContentIterator;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileFilter;

/**
 * @author <a href="mailto:derek@echologic.com">Derek Scherger</a>
 */
public class XFilesContentIterator implements ContentIterator {

    private VirtualFileFilter filter;
    private List included = new ArrayList();
    private List excluded = new ArrayList();

    public XFilesContentIterator(VirtualFileFilter filter) {
        this.filter = filter;
    }

    public boolean processFile(VirtualFile file) {
        if (filter.accept(file)) {
            included.add(file);
        } else {
            excluded.add(file);
        }

        return true;
    }

    public List getIncluded() {
        return included;
    }

    public List getExcluded() {
        return included;
    }

    public String toString() {
        return included.size() + " included; " +
            excluded.size() + " excluded";
    }
}