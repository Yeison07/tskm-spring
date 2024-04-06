import axiosInstance from '@/lib/config/axiosConfig';
import { TaskGateway } from '@/lib/domain/model/gateways/taskGateway';
import { Task } from '@/lib/domain/model/task';

export default class TaskRepository implements TaskGateway {
  private axios = axiosInstance;

  constructor() {}

  async createTask(task: Task): Promise<{ error?: any }> {
    try {
      await this.axios.post('/api/v1/users/getProjectByUserId'), task;
      return {};
    } catch (error) {
      return { error };
    }
  }
  async editTask(task: Task): Promise<{ error?: any }> {
    try {
      await this.axios.put('/api/v1/users/getProjectByUserId'), task;
      return {};
    } catch (error) {
      return { error };
    }
  }
  async updateTaskStatus(task: Task): Promise<{ error?: any }> {
    try {
      await this.axios.put('/api/v1/users/getProjectByUserId'), task;
      return {};
    } catch (error) {
      return { error };
    }
  }
  async assignTask(task: Task): Promise<{ error?: any }> {
    try {
      await this.axios.put('/api/v1/users/getProjectByUserId'), task;
      return {};
    } catch (error) {
      return { error };
    }
  }
}
