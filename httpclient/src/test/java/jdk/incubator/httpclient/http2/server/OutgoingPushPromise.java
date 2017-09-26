package jdk.incubator.httpclient.http2.server;/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

import java.io.*;
import java.net.*;
import jdk.incubator.http.internal.common.HttpHeadersImpl;
import jdk.incubator.http.internal.frame.Http2Frame;

// will be converted to a PushPromiseFrame in the writeLoop
// a thread is then created to produce the DataFrames from the InputStream
class OutgoingPushPromise extends Http2Frame {
    final HttpHeadersImpl headers;
    final URI uri;
    final InputStream is;
    final int parentStream; // not the pushed streamid

    public OutgoingPushPromise(int parentStream,
                               URI uri,
                               HttpHeadersImpl headers,
                               InputStream is) {
        super(0,0);
        this.uri = uri;
        this.headers = headers;
        this.is = is;
        this.parentStream = parentStream;
    }

}