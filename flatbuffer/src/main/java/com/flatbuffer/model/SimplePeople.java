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

package com.flatbuffer.model;

import android.util.Log;

import com.flatbuffer.jsonmodel.Bean;

import org.json.JSONException;
import org.json.JSONObject;

public class SimplePeople {
    private String id;
    private long index;
    private String guid;
    private String name;
    private String gender;
    private String company;
    private String email;

    public static SimplePeople fillData() {
        SimplePeople simplePeople = new SimplePeople();
        simplePeople.id = "1";
        simplePeople.index = 1;
        simplePeople.guid = "sdd";
        simplePeople.name = "cj";
        simplePeople.gender = "men";
        simplePeople.company = "cheetamobile";
        simplePeople.email = "cj3479@126.com";
        return simplePeople;
    }


    @Override
    public String toString() {
        return "SimplePeople{" +
                "id='" + id + '\'' +
                ", index=" + index +
                ", guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
