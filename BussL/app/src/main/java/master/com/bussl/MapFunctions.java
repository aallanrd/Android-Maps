package master.com.bussl;

import android.location.Location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Allan on 5/3/2015.
 */
public class MapFunctions {

    Location mLastLocation;
    GoogleApiClient mGoogleApiClient;
    GoogleMap mMap;

    public MapFunctions(GoogleApiClient apiClient,GoogleMap map ){

        this.mGoogleApiClient = apiClient;
        this.mMap = map;
    }



    public void getUserLocation( ){

        mGoogleApiClient.connect();


        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {

            LatLng userLocation = new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude());

            mMap.addMarker(new MarkerOptions().position(userLocation).title("Marker"));


           // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation,0));




        }

        mGoogleApiClient.disconnect();

    }

}
