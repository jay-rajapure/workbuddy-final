package com.byteMinds.jay.workbuddy2.Services;

import com.byteMinds.jay.workbuddy2.models.Users;
import com.byteMinds.jay.workbuddy2.models.Worker;

import java.util.List;

public interface LocationService {
    public List<Worker> getWorkersByDistance();

}
