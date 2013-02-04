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

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: Gregory Martin
 * Date: 2/4/13
 * Time: 1:49 PM
 *
 * Pager that holds Fragments to flip between
 */
public class FragmentPager extends FragmentPagerAdapter {
    /**
     * The total number of Fragments that would be in the Pager at any point in time
     */
    public static final int NUM_FRAGMENTS = 2;

    /**
     * {@inheritDoc}
     *
     * @param fm
     */
    public FragmentPager(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the Fragment associated with a specified position.
     */
    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return FragmentAlwaysThere.newInstance(position);
        } else if(position == 1) {
            return FragmentLandscape.newInstance(position);
        }

        return null;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return NUM_FRAGMENTS;
    }
}
