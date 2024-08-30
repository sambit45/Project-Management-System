import { createAsyncThunk } from "@reduxjs/toolkit";

export const getUserSubscription = createAsyncThunk(
    'subscription/getUserSubscription',
    async (jwt, { rejectWithValue }) => {
      try {
        const response = await fetch('/api/subscriptions/user', {
          headers: {
            Authorization: `Bearer ${jwt}`,
          },
        });
        if (!response.ok) {
          throw new Error('Failed to fetch user subscription');
        }
        const data = await response.json();
        console.log('user subscription', data);
        return data;
      } catch (error) {
        console.log(error);
        return rejectWithValue(error.message);
      }
    }
  );
  
  export const upgradeSubscription = createAsyncThunk(
    'subscription/upgradeSubscription',
    async ({ planType }, { rejectWithValue }) => {
      try {
        const response = await fetch(`/api/subscriptions/upgrade?planType=${planType}`, {
          method: 'PATCH',
        });
        if (!response.ok) {
          throw new Error('Failed to upgrade subscription');
        }
        const data = await response.json();
        console.log('upgrade subscription', data);
        return data;
      } catch (error) {
        console.log(error);
        return rejectWithValue(error.message);
      }
    }
  );