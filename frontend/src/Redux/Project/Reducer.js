import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  projects: [],
  loading: false,
  error: null,
  projectDetails: null,
  searchProjects: [],
};

const projectSlice = createSlice({
  name: 'projects',
  initialState,
  reducers: {
    fetchProjectsRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    createProjectRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    deleteProjectRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    fetchProjectByIdRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    acceptInvitationRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    inviteToProjectRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    fetchProjectsSuccess: (state, action) => {
      state.loading = false;
      state.projects = action.payload;
    },
    searchProjectSuccess: (state, action) => {
      state.loading = false;
      state.searchProjects = action.payload;
    },
    createProjectSuccess: (state, action) => {
      state.loading = false;
      state.projects.push(action.payload);
    },
    fetchProjectByIdSuccess: (state, action) => {
      state.loading = false;
      state.projectDetails = action.payload;
    },
    deleteProjectSuccess: (state, action) => {
      state.loading = false;
      state.projects = state.projects.filter(
        (project) => project.id !== action.payload
      );
    },
    setError: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },
  },
});

export const {
  fetchProjectsRequest,
  createProjectRequest,
  deleteProjectRequest,
  fetchProjectByIdRequest,
  acceptInvitationRequest,
  inviteToProjectRequest,
  fetchProjectsSuccess,
  searchProjectSuccess,
  createProjectSuccess,
  fetchProjectByIdSuccess,
  deleteProjectSuccess,
  setError,
} = projectSlice.actions;

export const projectReducer = projectSlice.reducer;
