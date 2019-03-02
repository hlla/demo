/*
 *    Copyright (C) 2016 Amit Shekhar
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.example.bean;

import java.io.Serializable;

public class SimplePeople implements Serializable {
    private static final long serialVersionUID = -5091230928570026268L;
    private String name0;
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String name5;
    private String name6;
    private String name7;
    private String name8;
    private String name9;
    private String name10;

    public static SimplePeople fillData() {
        SimplePeople simplePeople = new SimplePeople();
        return simplePeople;
    }

    public static SimplePeople fillData(String i) {
        SimplePeople simplePeople = new SimplePeople();
        simplePeople.name0 = "cheetamobile0" + i + "ssfd" + i;
        simplePeople.name1 = "cheetamobile1" + i + "ssfd" + i;
        simplePeople.name2 = "cheetamobile2" + i + "ssfd" + i;
        simplePeople.name3 = "cheetamobile3" + i + "ssfd" + i;
        simplePeople.name4 = "cheetamobile4" + i + "ssfd" + i;
        simplePeople.name5 = "cheetamobile5" + i + "ssfd" + i;
        simplePeople.name6 = "cheetamobile6" + i + "ssfd" + i;
        simplePeople.name7 = "cheetamobile7" + i + "ssfd" + i;
        simplePeople.name8 = "cheetamobile8" + i + "ssfd" + i;
        simplePeople.name9 = "cheetamobile9" + i + "ssfd" + i;
        simplePeople.name10 = "cheetamobile10" + i + "ssfd" + i;
        return simplePeople;
    }



    @Override
    public String toString() {
        return "SimplePeople{" +
                ", name0='" + name0 + '\'' +
                ", name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", name3='" + name3 + '\'' +
                ", name4='" + name4 + '\'' +
                ", name5='" + name5 + '\'' +
                ", name6='" + name6 + '\'' +
                ", name7='" + name7 + '\'' +
                ", name8='" + name8 + '\'' +
                ", name9='" + name9 + '\'' +
                '}';
    }
}
