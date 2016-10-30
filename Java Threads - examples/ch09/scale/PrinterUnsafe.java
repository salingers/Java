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


import java.text.*;
import java.util.*;

public class PrinterUnsafe implements ScaleTester {
	private float lookupValues[][];
	private int nRows, nCols, nThreads;
	LoopPrinterUnsafe lp;

	private class PrinterUnsafeHandler extends LoopHandler {
		PrinterUnsafeHandler(int nc, int nt) {
			super(0, nc, nt);
		}

		public void loopDoRange(int start, int end) {
			NumberFormat nf = null;
			while (nf == null) {
				try {
					nf = NumberFormat.getInstance();
				} catch (MissingResourceException mre) {
					System.err.println("MRE");
				}
			}
			nf.setMaximumFractionDigits(4);
			for (int i = start; i < end; i++) {
				lookupValues[0][i] = 0;
			}
			for (int i = start; i < end; i++) {
				for (int j = 1; j < nRows; j++) {
					float sinValue = (float)Math.sin((i % 360)*Math.PI/180.0);
					lookupValues[j][i] = sinValue * (float)i / 180.0f;
					lookupValues[j][i] += lookupValues[j-1][i]*(float)j/180.0f;
					if ((j % 20) == 0)
						lp.println(j * nCols + i, nf.format(lookupValues[j][i]));
				}  
			}
		}
	}

	public void init(int nRows, int nCols, int nThreads) {
		this.nRows = nRows;
		this.nCols = nCols;
		this.nThreads = nThreads;
		lookupValues = new float[nRows][];
		for (int j = 0; j < nRows; j++) {
			lookupValues[j] = new float[nCols];
		}
		lp = new LoopPrinterUnsafe(nCols * nRows);
	}	

	public float[][] doCalc() {
		PrinterUnsafeHandler loop = new PrinterUnsafeHandler(nCols, nThreads);
		loop.loopProcess();
		lp.send2stream(System.out);
		return lookupValues;
	}
}
