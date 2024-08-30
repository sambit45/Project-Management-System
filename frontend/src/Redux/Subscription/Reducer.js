import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  userSubscription: null,
  loading: false,
  error: null,
};

const subscriptionSlice = createSlice({
  name: 'subscription',
  initialState,
  reducers: {
    getUserSubscriptionRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    getUserSubscriptionSuccess: (state, action) => {
      state.loading = false;
      state.userSubscription = action.payload;
      state.error = null;
    },
    getUserSubscriptionFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },
    upgradeSubscriptionRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    upgradeSubscriptionSuccess: (state, action) => {
      state.loading = false;
      state.userSubscription = action.payload;
      state.error = null;
    },
    upgradeSubscriptionFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },
  },
});

export const {
  getUserSubscriptionRequest,
  getUserSubscriptionSuccess,
  getUserSubscriptionFailure,
  upgradeSubscriptionRequest,
  upgradeSubscriptionSuccess,
  upgradeSubscriptionFailure,
} = subscriptionSlice.actions;

export const subscriptionReducer = subscriptionSlice.reducer;