/*******************************************************************************
 * Copyright (c) 2013, Gregory Martin
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of Gregory Martin nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package com.gregfmartin.layoutsensitivefragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * Created with IntelliJ IDEA.
 * User: Gregory Martin
 * Date: 2/4/13
 * Time: 11:47 AM
 *
 * The entry point for the application.
 */
public class ActivityMain extends FragmentActivity {
    /**
     * Perform initialization of all fragments and loaders.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        configureFragments();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onRestart() {
        super.onRestart();

        configureFragments();
    }

    /**
     * Handles the FragmentTransaction responsible for injecting the appropriate Fragments into the layout.
     * If the device is in Landscape orientation, both Fragments are displayed side-by-side. If the device
     * is in Portrait orientation, a single Fragment is displayed.
     */
    private void configureFragments() {
        FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
        FragmentAlwaysThere fragAlwaysThere = new FragmentAlwaysThere();

        // Check to see if particular containers exists in the Layout
        if(findViewById(R.id.frameLayout_fragLandscapeContainer) != null) {
            // Landscape orientation
            FragmentLandscape fragLandscape = new FragmentLandscape();

            // Add the Fragments to the Activity
            fragTransaction.add(R.id.frameLayout_fragLandscapeContainer, fragLandscape, "fragLandscape");
            fragTransaction.add(R.id.frameLayout_fragAlwaysThereContainer, fragAlwaysThere, "fragAlwaysThere");
            fragTransaction.commit();
        } else if(findViewById(R.id.frameLayout_fragmentContainer) != null) {
            // Portrait
            fragTransaction.add(R.id.frameLayout_fragmentContainer, fragAlwaysThere, "fragAlwaysThere");
            fragTransaction.commit();
        }
    }
}
