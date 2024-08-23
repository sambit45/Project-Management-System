import { configureStore } from '@reduxjs/toolkit';
import { authReducer } from './Auth/Reducer';

const store = configureStore({
    reducer: {
        auth: authReducer,
    },
});

export default store;
