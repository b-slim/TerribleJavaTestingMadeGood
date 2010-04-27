/*
 *  Copyright 2010 martinh.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

package org.testpatterns.hamcrestexamples;

import java.util.Arrays;
import org.junit.Test;
import static org.hamcrest.collection.IsArrayContaining.hasItemInArray;
import static org.junit.matchers.JUnitMatchers.*;
import static org.junit.Assert.assertThat;



/**
 * Simple examples with hamcrest and arrays / collections.
 * 
 * @author martinh
 */
public class CollectionExamples {

    //Hamcrest with Collections and Arrays:
    static final String[] array = { "A", "B", "C" };

    @Test
    public void oneThingInArray () {
        assertThat(array, hasItemInArray("A"));
    }

    @Test
    public void arrayOfItemsInList () {
        String[] expected = { "A", "B", "C" };
        assertThat(Arrays.asList(array), hasItems(expected));
    }

    @Test
    public void itemInAList () {
        assertThat(Arrays.asList(array), hasItem("A"));
    }

    @Test
    public void itemsInAList () {
        assertThat(Arrays.asList(array), hasItems("A", "C"));
    }

}
