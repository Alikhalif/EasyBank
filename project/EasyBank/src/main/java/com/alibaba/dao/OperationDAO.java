package com.alibaba.dao;

import com.alibaba.entities.Operation;

public interface OperationDAO {
    void createOperation(Operation operation);
    Operation getOperationByNumber(int operationNumber);
}
