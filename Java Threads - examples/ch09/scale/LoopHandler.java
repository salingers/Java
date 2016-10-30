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


public class LoopHandler implements Runnable {
	protected class LoopRange {
		public int start, end;
	}
	protected Thread lookupThreads[];
	protected int startLoop, endLoop, curLoop, numThreads;

	public LoopHandler(int start, int end, int threads) {
		startLoop = curLoop = start;
		endLoop = end;
		numThreads = threads;
		lookupThreads = new Thread[numThreads];
	}

	protected synchronized LoopRange loopGetRange() {
		if (curLoop >= endLoop)
			return null;
		LoopRange ret = new LoopRange();
		ret.start = curLoop;
		curLoop += (endLoop-startLoop)/numThreads+1;
		ret.end = (curLoop<endLoop)?curLoop:endLoop;
		return ret;
	}

	public void loopDoRange(int start, int end) {
	}

	public void loopProcess() {
		for (int i = 0; i < numThreads; i++) {
			lookupThreads[i] = new Thread(this);
			lookupThreads[i].start();
		}
		for (int i = 0; i < numThreads; i++) {
			try {
				lookupThreads[i].join();
			} catch (InterruptedException iex) {}
		}
	}
 
	public void run() {
		LoopRange str;
		while ((str = loopGetRange()) != null) {
			loopDoRange(str.start, str.end);
		}
	}
}
