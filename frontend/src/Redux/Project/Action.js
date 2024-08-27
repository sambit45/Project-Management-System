import { createAsyncThunk } from '@reduxjs/toolkit';
import { api } from '@/Config/api';

export const fetchProjects = createAsyncThunk(
  'projects/fetchProjects',
  async ({ category, tag }) => {
    const queryParams = new URLSearchParams({ category, tag }).toString();
    const data = await api(`/api/projects?${queryParams}`);
    console.log('all projects', data);
    return data;
  }
);

export const searchProjects = createAsyncThunk(
  'projects/searchProjects',
  async (keyword) => {
    const data = await api(`/api/projects/search?keyword=${encodeURIComponent(keyword)}`);
    console.log('search projects', data);
    return data;
  }
);

export const createProjects = createAsyncThunk(
  'projects/createProjects',
  async (projectData) => {
    const data = await api('/api/projects', {
      method: 'POST',
      body: JSON.stringify(projectData),
    });
    console.log('created project', data);
    return data;
  }
);

export const fetchProjectById = createAsyncThunk(
  'projects/fetchProjectById',
  async (id) => {
    const data = await api(`/api/projects/${id}`);
    console.log('project', data);
    return data;
  }
);

export const deleteProjects = createAsyncThunk(
  'projects/deleteProjects',
  async (projectId) => {
    const data = await api(`/api/projects/${projectId}`, {
      method: 'DELETE',
    });
    console.log('deleted project', data);
    return projectId;
  }
);

export const inviteToProject = createAsyncThunk(
  'projects/inviteToProject',
  async ({ email, projectId }) => {
    const data = await api('/api/projects/invite', {
      method: 'POST',
      body: JSON.stringify({ email, projectId }),
    });
    console.log('invite to project', data);
    return data;
  }
);

export const acceptInvitation = createAsyncThunk(
  'projects/acceptInvitation',
  async ({ invitationToken, navigate }) => {
    const queryParams = new URLSearchParams({ token: invitationToken }).toString();
    const data = await api(`/api/projects/accept_invitation?${queryParams}`);
    navigate(`/project/${data.projectId}`);
    console.log('accept invitation', data);
    return data;
  }
);
