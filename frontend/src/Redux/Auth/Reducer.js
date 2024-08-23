import { createSlice } from '@reduxjs/toolkit';

const initialState = {
    user: null,
    loading: false,
    error: null,
    jwt: null,
    projectSize: 0
};

const authSlice = createSlice({
    name: 'auth',
    initialState,
    reducers: {
        registerRequest: (state) => {
            state.loading = true;
            state.error = null;
        },
        loginRequest: (state) => {
            state.loading = true;
            state.error = null;
        },
        getUserRequest: (state) => {
            state.loading = true;
            state.error = null;
        },
        registerSuccess: (state, action) => {
            state.loading = false;
            state.jwt = action.payload.jwt;
        },
        loginSuccess: (state, action) => {
            state.loading = false;
            state.jwt = action.payload.jwt;
        },
        getUserSuccess: (state, action) => {
            state.loading = false;
            state.user = action.payload;
        },
        logout: () => initialState,
    }
});

export const {
    registerRequest,
    loginRequest,
    getUserRequest,
    registerSuccess,
    loginSuccess,
    getUserSuccess,
    logout,
} = authSlice.actions;

export const authReducer = authSlice.reducer;
