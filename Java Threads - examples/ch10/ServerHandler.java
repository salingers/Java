/*
 *
 * Copyright (c) 1997-1999 Scott Oaks and Henry Wong. All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and
 * without fee is hereby granted.
 *
 * This sample source code is provided for example only,
 * on an unsupported, as-is basis. 
 *
 * AUTHOR MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. AUTHOR SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 * THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
 * CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
 * PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
 * NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
 * SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
 * SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
 * PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES").  AUTHOR
 * SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
 * HIGH RISK ACTIVITIES.
 */


import java.net.*;
import java.io.*;

class CalculateThread extends Thread {
	OutputStream os;
		CalculateThread(ThreadGroup tg, OutputStream os) {
		super(tg, "Client Calculate Thread");
		this.os = os;
	}
	public void run() {
		// do the calculation, sending results to the OutputStream os
	}
}

public class ServerHandler extends TCPServer {
	public static final int INTERRUPT = 0;
	public static final int CALCULATE = 1;
	ThreadGroup tg;
	public boolean shouldRun;

	private int getCommand(InputStream is) {
		// read the command data
		return CALCULATE;
	}

	public void run(Socket data) {
		tg = new ThreadGroup("Client Thread Group");
		try {
			InputStream is = data.getInputStream();
			OutputStream os = data.getOutputStream();
			while (shouldRun) {
				switch(getCommand(is)) {
					case INTERRUPT:
						tg.interrupt();
						break;
					case CALCULATE:
						new CalculateThread(tg, os).start();
						break;
				}
			}
		} catch (Exception e) {
			tg.interrupt();
		}
	}

	public static void main(String args[]) throws Exception {
		TCPServer serv = new ServerHandler();
		serv.startServer(300);
	}
}
