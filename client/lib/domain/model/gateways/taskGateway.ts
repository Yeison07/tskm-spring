import { Task } from '../task';

export interface TaskGateway {
  createTask(task: Task): Promise<{ error?: any }>;
  editTask(task: Task): Promise<{ error?: any }>;
  updateTaskStatus(task: Task): Promise<{ error?: any }>;
  assignTask(task: Task): Promise<{ error?: any }>;
}
