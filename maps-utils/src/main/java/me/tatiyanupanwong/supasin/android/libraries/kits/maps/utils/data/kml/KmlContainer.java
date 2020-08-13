/*
 * Copyright 2020 Supasin Tatiyanupanwong
 * Copyright 2020 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.tatiyanupanwong.supasin.android.libraries.kits.maps.utils.data.kml;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;

import me.tatiyanupanwong.supasin.android.libraries.kits.maps.model.GroundOverlay;

/**
 * Represents a KML Document or Folder.
 */
public class KmlContainer {

    private final HashMap<String, String> mProperties;

    private final HashMap<KmlPlacemark, Object> mPlacemarks;

    private final ArrayList<KmlContainer> mContainers;

    private final HashMap<KmlGroundOverlay, GroundOverlay> mGroundOverlays;

    private final HashMap<String, String> mStyleMap;

    private final HashMap<String, KmlStyle> mStyles;

    private final String mContainerId;

    KmlContainer(
            HashMap<String, String> properties,
            HashMap<String, KmlStyle> styles,
            HashMap<KmlPlacemark, Object> placemarks,
            HashMap<String, String> styleMaps,
            ArrayList<KmlContainer> containers,
            HashMap<KmlGroundOverlay, GroundOverlay> groundOverlay,
            String id) {
        mProperties = properties;
        mPlacemarks = placemarks;
        mStyles = styles;
        mStyleMap = styleMaps;
        mContainers = containers;
        mGroundOverlays = groundOverlay;
        mContainerId = id;
    }

    /**
     * @return Map of Kml Styles, with key values representing style name (ie, color) and
     * value representing style value (ie #FFFFFF)
     */
    HashMap<String, KmlStyle> getStyles() {
        return mStyles;
    }

    /**
     * @param placemarks Placemark for the container to contain
     * @param object Corresponding MapClient map object of the basic_placemark (if it has
     * been added to the map)
     */
    void setPlacemark(KmlPlacemark placemarks, Object object) {
        mPlacemarks.put(placemarks, object);
    }

    /**
     * @return A map of strings representing a style map, null if no style maps exist
     */
    HashMap<String, String> getStyleMap() {
        return mStyleMap;
    }

    /**
     * Gets all of the ground overlays which were set in the container
     *
     * @return A set of ground overlays
     */
    HashMap<KmlGroundOverlay, GroundOverlay> getGroundOverlayHashMap() {
        return mGroundOverlays;
    }

    /**
     * Gets the Container ID if it is specified
     *
     * @return Container ID or null if not set
     */
    public String getContainerId() {
        return mContainerId;
    }

    /**
     * Gets a style based on an ID
     */
    public KmlStyle getStyle(String styleID) {
        return mStyles.get(styleID);
    }

    /**
     * Gets a style Id from map based on an ID
     */
    public String getStyleIdFromMap(String styleID) {
        return mStyleMap.get(styleID);
    }


    /**
     * @return HashMap of containers
     */
    HashMap<KmlPlacemark, Object> getPlacemarksHashMap() {
        return mPlacemarks;
    }

    /**
     * Gets the value of a property based on the given key
     *
     * @param propertyName property key to find
     * @return value of property found, null if key doesn't exist
     */
    public String getProperty(String propertyName) {
        return mProperties.get(propertyName);
    }

    /**
     * Gets whether the container has any properties.
     *
     * @return {@code true} if there are properties, {@code false} otherwise
     */
    public boolean hasProperties() {
        return mProperties.size() > 0;
    }

    /**
     * Gets whether the given key exists in the properties.
     *
     * @param keyValue property key to find
     * @return {@code true} if key was found, {@code false} otherwise
     */
    public boolean hasProperty(String keyValue) {
        return mProperties.containsKey(keyValue);
    }

    /**
     * Gets whether the container has containers.
     *
     * @return {@code true} if there are containers, {@code false} otherwise
     */
    public boolean hasContainers() {
        return mContainers.size() > 0;
    }

    /**
     * Gets an iterable of nested KmlContainers.
     *
     * @return iterable of KmlContainers
     */
    public Iterable<KmlContainer> getContainers() {
        return mContainers;
    }

    /**
     * Gets an iterable of the properties hashmap entries.
     *
     * @return iterable of the properties hashmap entries
     */
    public Iterable<String> getProperties() {
        return mProperties.keySet();
    }

    /**
     * Gets an iterable of KmlPlacemarks.
     *
     * @return iterable of KmlPlacemarks
     */
    public Iterable<KmlPlacemark> getPlacemarks() {
        return mPlacemarks.keySet();
    }

    /**
     * Gets whether the container has any placemarks.
     *
     * @return {@code true} if there are placemarks, {@code false} otherwise
     */
    public boolean hasPlacemarks() {
        return mPlacemarks.size() > 0;
    }

    /**
     * Gets an iterable of KmlGroundOverlay objects
     *
     * @return iterable of KmlGroundOverlay objects
     */
    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return mGroundOverlays.keySet();
    }

    @NonNull
    @Override
    public String toString() {
        return "Container" + "{" +
                "\n properties=" + mProperties +
                ",\n placemarks=" + mPlacemarks +
                ",\n containers=" + mContainers +
                ",\n ground overlays=" + mGroundOverlays +
                ",\n style maps=" + mStyleMap +
                ",\n styles=" + mStyles +
                "\n}\n";
    }
}
