# MySQL Database Schema Design

## Tables
1. **Patient**: Stores patient details.
   - `id` (INT, Primary Key, Auto Increment)
   - `name` (VARCHAR)
   - `email` (VARCHAR, Unique)
   - `phone` (VARCHAR)
   - `password_hash` (VARCHAR)

2. **Doctor**: Stores doctor details.
   - `id` (INT, Primary Key, Auto Increment)
   - `name` (VARCHAR)
   - `specialty` (VARCHAR)
   - `email` (VARCHAR, Unique)
   - `password_hash` (VARCHAR)

3. **Appointment**: Links doctors and patients.
   - `id` (INT, Primary Key, Auto Increment)
   - `doctor_id` (INT, Foreign Key -> Doctor.id)
   - `patient_id` (INT, Foreign Key -> Patient.id)
   - `appointment_time` (DATETIME)
   - `status` (VARCHAR)

4. **Prescription**: Links to appointments.
   - `id` (INT, Primary Key, Auto Increment)
   - `appointment_id` (INT, Foreign Key -> Appointment.id)
   - `medication` (VARCHAR)
   - `dosage` (VARCHAR)